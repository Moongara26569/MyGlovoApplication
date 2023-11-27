import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PropietarioAction {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsonRespuesta = "";
        String action = request.getParameter("ACTION");
        action = "PROPIETARIO.LOGIN";
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

        Propietario propietario = new Propietario();
        propietario.setNombre(nombre);
        propietario.setPassword(pass);
        PropietarioDAO propietarioDAO = new PropietarioDAO();
        boolean propietariosEncontrados = propietarioDAO.find(propietario);

        if( propietariosEncontrados){

            int idRestaurante = propietario.getIdRestaurante();
            msg = "{\n" +
                    "    \"message\": \"Login-propietario correcto. \",\n" +
                    "    \"propietario\": {\n" +
                    "        \"nombre\":\"" + propietario.getNombre() + "\",\n" +
                    "        \"password\": \"" + propietario.getPassword() + "\",\n" +
                    "        \"idRestaurante\": \"" + idRestaurante + "\"\n" +
                    "    }\n" +
                    "}";
        } else {
            msg = "{\n" +
                    "    \"message\": \"Login incorrecto. \",\n" +
                    "    \"propietario\": {\n" +
                    "        \"nombre\":\"" + propietario.getNombre() + "\",\n" +
                    "        \"password\": \"" + propietario.getPassword() + "\"\n" +
                    "    }\n" +
                    "}";
        }

        return msg;
    }
}
