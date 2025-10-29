import SwiftUI
import ComposeApp

@main
struct iOSApp: SwiftUI.App {
    init() {
        PlatformModule_iosKt.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
