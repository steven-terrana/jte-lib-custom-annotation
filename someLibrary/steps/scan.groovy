// not strictly necessary bc default package
import Container

@Container(dynamic = { resource("container.yaml") })
void call(){
  println "scan - not annotated"
}
