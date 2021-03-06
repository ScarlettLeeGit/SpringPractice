package spring_board.ex.BController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_board.ex.command.*;
import spring_board.ex.util.Constant;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class BController {

    BCommand command;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        Constant.jdbcTemplate = this.jdbcTemplate;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        command = new BListCommand();
        command.execute(model);

        return "list";
    }

    @RequestMapping("/write_view")
    public String write_view(Model model) {

        return "write_view";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BWriteCommand();
        command.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/content_view")
    public String content_view(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BContentCommand();
        command.execute(model);

        return "content_view";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String modify(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BModifyCommand();
        command.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/reply_view")
    public String reply_view(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BReplyViewCommand();
        command.execute(model);

        return "reply_view";
    }

    @RequestMapping("/reply")
    public String reply(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BReplyCommand();
        command.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        command = new BDeleteCommand();
        command.execute(model);

        return "redirect:list";
    }
}
