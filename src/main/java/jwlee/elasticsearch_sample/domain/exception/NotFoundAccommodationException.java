package jwlee.elasticsearch_sample.domain.exception;

public class NotFoundAccommodationException extends RuntimeException {
    public NotFoundAccommodationException() {
        super("등록되지않은 숙소입니다.");
    }
}
