// not strictly necessary bc default package
import Container

@Container(dynamic = { resource("container.yaml") })
void call(){}

@Container(dynamic = { ["dynamic_value_1", "dynamic_value_2"] })
void doesNotMatter()
