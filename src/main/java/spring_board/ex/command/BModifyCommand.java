package spring_board.ex.command;

import org.springframework.ui.Model;
import spring_board.ex.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BModifyCommand implements BCommand {
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String bId = request.getParameter("bId");
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        BDao dao = new BDao();
        dao.modify(bId, bName, bTitle, bContent);
    }
}
