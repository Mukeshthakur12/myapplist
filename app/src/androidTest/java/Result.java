import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("name");
    private String SuperName;

    public Results(String name)
    {
        this.SuperName = name;
    }
    public String getName() {
        return superName;
    }
}
