import java.util.List;

public class ListOfFilmes {
    List<Filme> items;
    String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<Filme> getItems() {
        return this.items;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setItems(List<Filme> items) {
        this.items = items;
    }
}