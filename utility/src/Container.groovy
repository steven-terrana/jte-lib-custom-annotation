import static java.lang.annotation.RetentionPolicy.RUNTIME
import java.lang.annotation.Retention

/**
 * Annotation marking a library step method to potentially execute after other step executions
 */
@Retention(RUNTIME)
@interface Container{

    String value()

}
