import SwiftUI
import SampleSDK

struct ContentView: View {
    let greet = "text"

	var body: some View {
		ContentViewInterop()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

struct ContentViewInterop: UIViewControllerRepresentable {
        
    func makeUIViewController(context: Context) -> UIViewController {
        return MainAppKt.MainApp()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
