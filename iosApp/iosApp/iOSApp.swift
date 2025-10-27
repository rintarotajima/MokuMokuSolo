import SwiftUI

@main
struct iOSApp: App {
    init() {
        DIKoinKt.initKoin {
            modules([DIKoinKt.iosModule()])
        }
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}