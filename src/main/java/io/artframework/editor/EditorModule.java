package io.artframework.editor;

import io.artframework.ArtContext;
import io.artframework.BootstrapScope;
import io.artframework.ParseException;
import io.artframework.Scope;
import io.artframework.annotations.ArtModule;
import io.artframework.annotations.OnBootstrap;
import io.artframework.annotations.OnDisable;
import io.artframework.annotations.OnEnable;
import io.artframework.annotations.OnLoad;
import io.artframework.annotations.OnReload;

import java.util.Arrays;
import java.util.List;

@ArtModule(
    value = "art-editor",
    description = {
            "An editor API extension for the art-framework.",
            "Allows other modules to pass their config to the editor and receive a callback when the content was edited."
    },
    version = "@VERSION@",
    prefix = "art-editor"
)
public class EditorModule {

    private DummyEditor editor;
    private WebEditor webEditor;
    private ArtContext context;

    @OnBootstrap
    public void onBootstrap(BootstrapScope scope) {

        this.editor = new DummyEditor(scope);
        this.webEditor = new WebEditor(scope);

        scope.addSingletonProvider(Editor.class, editor);
        scope.addSingletonProvider(WebEditor.class, webEditor);
    }
    
    @OnLoad
    public void onLoad(Scope scope) {

    }
    
    @OnEnable
    public void onEnable(Scope scope) {

        try {
            List<String> cfg = Arrays.asList(
                    "foob",
                    "bar"
            );
            context = scope.load(cfg);
            webEditor.edit(cfg).onChange(session -> {
                try {
                    context = scope.load(session.output());
                } catch (ParseException e) {
                    // TODO: catch exception
                }
            }).open(url -> {});
        } catch (ParseException e) {
            // TODO: catch exception
        }
    }

    @OnReload
    public void onReload(Scope scope) {

    }

    @OnDisable
    public void onDisable(Scope scope) {

    }
}
