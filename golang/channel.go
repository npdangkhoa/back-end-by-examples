package channel

import (
	"fmt"
	"time"
)

func pinger(c chan string){
	for i:=0; ; i ++ {
		c <- "ping"
	}
}

func printer(c chan string){
	msg := <- c
	fmt.Println(msg)
	time.Sleep(time.Second *1)
}

func channel() {
	var c chan string = make(chan string)

	go pinger(c)
	go printer(c)

	var input string
	fmt.Scanln(&input)

	
}