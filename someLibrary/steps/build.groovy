// not strictly necessary bc default package
import Container

@Container("buildContainer")
void call(){
  println "build step"
}
