// not strictly necessary bc default package
import Container

@Container("static_single_value")
void call(){}

@Container(["static_array_1", "static_array_2"])
void doesNotMatter(){}
