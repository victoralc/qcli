package dev.learn;

import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.element.Element;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import static dev.tamboui.toolkit.Toolkit.*;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            System.out.println("Starting TamboUI");
            new HelloDsl().runApp();
            Quarkus.waitForExit();
            return 0;
        }
    }

    public static class HelloDsl extends ToolkitApp {

        @Override
        protected Element render() {
            return panel("Hello",
                    text("Welcome to TamboUI DSL!").bold().cyan(),
                    spacer(),
                    text("Press 'q' to quit").dim()
            ).rounded();
        }

        public void runApp() throws Exception {
            new HelloDsl().run();
        }
    }
}
