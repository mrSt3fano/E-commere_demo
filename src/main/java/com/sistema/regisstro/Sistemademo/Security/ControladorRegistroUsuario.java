package com.sistema.regisstro.Sistemademo.Security;

import java.io.IOException;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.ServicioUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ControladorRegistroUsuario implements AuthenticationSuccessHandler {

    private ServicioUsuario vars;

    @Autowired
    public ControladorRegistroUsuario(ServicioUsuario theUserService) {
        vars = theUserService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        System.out.println("Obteniendo usuario");
        String usuario = authentication.getName();
        System.out.println("usuario=" + usuario);

        Usuario theUser = vars.encontrarUsuarioAhora(usuario);

        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);

        response.sendRedirect(request.getContextPath() + "/");
    }

}
