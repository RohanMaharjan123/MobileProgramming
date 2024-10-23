# Program for print Hello-World in IOS app

**Name**: Program for print Hello-World in IOS app

**Date**: October 23rd, 2024

## Source Code

## applicationApp.swift Code

```swift
import SwiftUI

@main
struct applicationApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
```

## ContentView.swift Code

```swift

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
```

## Output

![Program for print Hello-World in IOS app](./output.png)
