import Container
import org.boozallen.plugins.jte.init.primitives.TemplatePrimitiveCollector
import org.boozallen.plugins.jte.init.primitives.injectors.StepWrapper

@Init
void call(){
  // store the annotation values
  List<String> containers = []
  // fetch the loaded library steps
  TemplatePrimitiveCollector jte = TemplatePrimitiveCollector.current()
  List<StepWrapper> steps = jte.getPrimitives().findAll{ it in StepWrapper }
  // get the annotation's value 
  steps.each{ step ->
    def script = step.getScript()
    script.class.methods.each{ method ->
      method.getAnnotations().each{ annotation ->
        if(annotation instanceof Container){
          // get static values: @Container("someContainer") or @Container(["a", "b"])
          def value = annotation.value()
          if(value instanceof String) containers.push(value)
          else if (value instanceof String[]) containers.addAll(value)
          
          // get dynamic values: @Container(dynamic={ // returns a string or array of Strings })
          def d = annotation.dynamic().newInstance(script, script).call()
          if(d instanceof String) containers.push(d)
          else if (d instanceof Collection) containers.addAll(d)
        }
      }
    }
  }
  println containers
}
