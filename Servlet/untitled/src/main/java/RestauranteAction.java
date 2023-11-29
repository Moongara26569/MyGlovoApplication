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
        System.out.println("Entrando en el metodo list all");
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        ArrayList<Restaurante> restaurantes = restauranteDAO.findAll("SELECT  *  FROM RESTAURANTES");
        String filtro = request.getParameter("FILTRO");

        System.out.println(filtro);

        switch(filtro){
            case "ITALIANA":
                restaurantes = restauranteDAO.findAll("SELECT  *  FROM RESTAURANTES WHERE categoria ='Italiana'");
                break;
            case "MEXICANA":
                restaurantes = restauranteDAO.findAll("SELECT  *  FROM RESTAURANTES WHERE categoria ='Mexicana'");
                break;
            case "PARRILLA":
                restaurantes = restauranteDAO.findAll("SELECT  *  FROM RESTAURANTES WHERE categoria ='Parrilla'");
                break;
            case "":
                restaurantes = restauranteDAO.findAll("SELECT  *  FROM RESTAURANTES");
                break;
        }
        String json = "{\n" +
                "    \"message\": \"Listado restaurantes \",\n" +
                "    \"lstRestaurantes\": [\n";

        int size = restaurantes.size();
        for (int i = 0; i < size; i++) {
            Restaurante rest = restaurantes.get(i);
            json += "        {\n" +
                    "            \"nombre\":\"" + rest.getNombre() + "\",\n" +
                    "            \"desc\": \"" + rest.getDesc() + "\",\n" +
                    "            \"tlfn\": \"" + rest.getTlfn() + "\", \n" +
                    "            \"categoria\": \"" + rest.getCategoria() + "\" \n" +
                    "        }";

            // Agregar una coma solo si no es el último elemento
            if (i < size - 1) {
                json += ",";
            }

            json += "\n";
        }

        json += "    ]\n" +
                "}";
        System.out.println(json);


        return json;
    }
}
