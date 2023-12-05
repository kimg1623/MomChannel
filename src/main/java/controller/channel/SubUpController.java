package controller.channel;

import dao.ChannelDAO;
import dao.MemberDAO;
import dao.SubDAO;
import vo.ChannelVO;
import vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ch/subup.do")
public class SubUpController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChannelDAO cdao = new ChannelDAO();
        String channelTitle = req.getParameter("channelTitle");
        SubDAO sdao = new SubDAO();
        HttpSession session = req.getSession();

        String memId = (String) session.getAttribute("memId");
        ChannelVO cvo = cdao.selectChannel(channelTitle);

        Map<String, String> map = new HashMap<>();
        map.put("memId",memId);
        map.put("channelTitle", cvo.getChannelTitle());

        cdao.subPlus(cvo.getMemId());
        sdao.subUp(map);

        resp.sendRedirect("../ch/chview.do?channelTitle=" + channelTitle);

    }
}
