import static java.lang.annotation.RetentionPolicy.RUNTIME
import java.lang.annotation.Retention

/**
 * mark library step methods with this annotation to register
 * a container for the pipeline run's pod template
 */
@Retention(RUNTIME)
@interface Container{

    String[] value() default []

    Class dynamic() default {}

}