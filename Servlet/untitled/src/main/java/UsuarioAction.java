/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UsuarioAction {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsonRespuesta = "";
        String action = request.getParameter("ACTION");
        action = "USUARIO.LOGIN";
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "LOGIN":
                jsonRespuesta = login(request, response);
                break;
        }
        return jsonRespuesta;
    }
    
    private String login(HttpServletRequest request,
            HttpServletResponse response) {
        
        String nombre = request.getParameter("NOMBRE");
        String pass = request.getParameter("PASSWORD");
        String msg = "";

            Usuario usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setPassword(pass);
                UserDAO usuarioDAO = new UserDAO();
                boolean usuariosEncontrados = usuarioDAO.findAll(usuario);

            if( usuariosEncontrados){
                msg = "{\n" +
                        "    \"message\": \"Login correcto. \",\n" +
                        "    \"lstUsers\": [\n" +
                        "        {\n" +
                        "            \"username\":\"" +  usuario.getNombre() + "\",\n" +
                        "            \"token\": \"" +  usuario.getPassword() + "\" \n" +
                        "        }" +
                        "    ]\n" +
                        "}";
                // msg = "true";
            }else{
                msg = "{\n" +
                        "    \"message\": \"Login incorrecto. \",\n" +
                        "    \"lstUsers\": [\n" +
                        "        {\n" +
                        "            \"username\":" +  usuario.getNombre() + ",\n" +
                        "            \"token\": " +  usuario.getPassword() + "\n" +
                        "        }" +
                        "    ]\n" +
                        "}";
            };
            
        
       return msg;
    }
    
    
}
