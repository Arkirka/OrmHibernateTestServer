package servlets;

import accounts.AccountsService;
import accounts.UserProfile;
import org.eclipse.jetty.server.handler.ResourceHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountsService accountsService;
    private UserProfile userProfile;

    public SignUpServlet(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("html");
        accountsService.getUserByLogin(request.getParameter("login"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userProfile = new UserProfile(request.getParameter("login"));
        accountsService.addNewUser(userProfile);
    }
}
