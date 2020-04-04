package main

import "fmt"

func main(){
	favNums3 := [5]float64{1,2,3,4,5}

	for i, value:= range favNums3{
		fmt.Println(value, i);
	}
}