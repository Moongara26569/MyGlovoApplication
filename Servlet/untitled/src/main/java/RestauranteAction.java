import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RestauranteAction {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsonRespuesta = "";
        String action = request.getParameter("ACTION");
        action = "RESTAURANTE.ALLRESTAURANTS";
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "ALLRESTAURANTS":
                jsonRespuesta = allRestaurants(request, response);
                break;
        }
        return jsonRespuesta;
    }

    private String allRestaurants(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Restaurante> restaurantes = RestauranteDAO.findAll();

        StringBuilder jsonRespuesta = new StringBuilder();
        jsonRespuesta.append("[");

        for (Restaurante restaurante : restaurantes) {
            jsonRespuesta.append("{");
            jsonRespuesta.append("\"idRestaurante\": ").append(restaurante.getIdRestaurante()).append(",");
            jsonRespuesta.append("\"nombre\": \"").append(restaurante.getNombre()).append("\",");
            jsonRespuesta.append("\"desc\": \"").append(restaurante.getDesc()).append("\",");
            jsonRespuesta.append("\"tlfn\": \"").append(restaurante.getTlfn()).append("\",");
            jsonRespuesta.append("\"categoria\": \"").append(restaurante.getCategoria()).append("\"");
            jsonRespuesta.append("},");
        }

        // Eliminar la coma final si hay elementos en la lista
        if (!restaurantes.isEmpty()) {
            jsonRespuesta.deleteCharAt(jsonRespuesta.length() - 1);
        }

        jsonRespuesta.append("]");

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(jsonRespuesta.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonRespuesta.toString();
    }
}
