package main

import "fmt"

func main(){
	fmt.Println("hello Golang")

	// We pass the value of a variable to the function
	x:= 0
	changeVal(x);
	fmt.Println("X=",x);

	// If we pass a reference to the variable we can change the value
	// in a function
	changeValPointer(&x)
	fmt.Println("X=", x);
	
}


func changeVal(x int){
	x=2;
}

func changeValPointer(x *int){
	*x=2;
}