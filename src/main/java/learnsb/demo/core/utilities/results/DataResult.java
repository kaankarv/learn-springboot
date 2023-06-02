package learnsb.demo.core.utilities.results;

//ne dondurecegimiz belli olmadigi icin generic <T>
public class DataResult<T> extends Result{

    private T data;

    public DataResult(T data, boolean success, String message) {

        // buradaki super base sinifin constructorlarini calistirmaya yarar
        super(success, message);
        this.data = data;

    }

    public DataResult(T data, boolean success) {

        super(success);
        this.data = data;

    }

    public T getData(){
        return this.data;
    }


}
