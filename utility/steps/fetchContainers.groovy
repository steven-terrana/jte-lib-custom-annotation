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
          String value = annotation.value().join()
          if(value) containers.push(v)

          // get dynamic values: @Container(dynamic={ // returns a string or array of Strings })
          def d = a.dynamic().newInstance(script, script).call()
          if(d instanceof String) containers.push(d)
          elseif (d instanceof List<String>) containers.addAll(d)
        }
      }
    }
  }
  println containers
}
