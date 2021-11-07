import java.util.NoSuchElementException;
import java.util.Objects;

//@author Daria Skliarova

public class Optional<T> {

    private T data;

    private Optional(T data) {
        this.data = data;
    }

    public boolean isPresent(){
        if (data == null){
            return false;
        }
        return true;
    }

    public T get(){
        if  (data == null){
            throw new NoSuchElementException();
        }
        return data;
    }

    public static <T> Optional<T> of(T value){
        if (value == null){
            throw new NullPointerException();
        }
        return new Optional<T>(value);
    }

    public static <T> Optional<T> ofNullable(T value){
        Optional<T> optional = new Optional<>(value);
        return optional;
    }

    public static <T> Optional<T> empty(){
        Optional<T> optional = new Optional<>(null);
        return optional;
    }

    public T orElse(T other){
        Optional<T> optional = new Optional<>(data);
        if (optional.isPresent()){
            return data;
        }
        return other;
    }

    @Override
    public boolean equals(Object obj) {
        Optional<T> optional = new Optional<>(data);
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<T> other = (Optional) obj;
        if (!(this.isPresent() && other.isPresent())){
            return true;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public int hashCode(){
        Optional<T> optional = new Optional<>(data);
        if (optional.isPresent()){
            return Objects.hash(optional);
        }
        return 0;
    }
}
