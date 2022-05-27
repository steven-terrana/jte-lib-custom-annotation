import Container
import org.boozallen.plugins.jte.init.primitives.TemplatePrimitiveCollector
import org.boozallen.plugins.jte.init.primitives.hooks.AnnotatedMethod
import org.boozallen.plugins.jte.init.primitives.hooks.Hooks
import org.boozallen.plugins.jte.init.primitives.injectors.StepWrapper

@Init
void call(){
  // store the annotation values
  List<String> containers = []
  // fetch the loaded library steps
  TemplatePrimitiveCollector jte = TemplatePrimitiveCollector.current()
  List<StepWrapper> steps = jte.getPrimitives().findAll{ it in StepWrapper }
  // find all of the Container annotations and fetch their value
  // NOTE:  
  //   i'm pretty sure you have to compare Strings instead of just doing
  //   method.getAnnotation(Container) because each step is compiled with 
  //   a different classloader? maybe a JTE 'bug', though i'm not sure what
  //   we're doing here is something i want to formally "support"
  steps.each{ step ->
    step.getScript().class.methods.each{ method ->
      method.getAnnotations().each{ a ->
        if(a.annotationType().toString() == Container.toString()){
          containers << a.value()
        }
      }
    }
  }
  println containers
}