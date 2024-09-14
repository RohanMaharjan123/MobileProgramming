//
//  ContentView.swift
//  Factorial
//
//  Created by Rohan Maharjan on 9/14/24.
//

import SwiftUI

struct FactorialCalculatorView: View {
    @State private var inputNumber = ""
    @State private var result = ""

    func calculateFactorial() {
        guard let number = Int(inputNumber) else {
            result = "Invalid input"
            return
        }

        if number < 0 {
            result = "Factorial is not defined for negative numbers"
            return
        }

        var factorial = 1
        for i in 1...number {
            factorial *= i
        }
        result = "Factorial of \(number) is \(factorial)"
    }

    var body: some View {
        VStack {
            TextField("Enter a number", text: $inputNumber)
                .keyboardType(.numberPad)
                .padding()

            Button("Calculate Factorial") {
                calculateFactorial()
            }
            .padding()

            Text(result)
                .padding()
        }
        .padding()
    }
}

struct ContentView: View {
    var body: some View {
        FactorialCalculatorView()
    }
}
