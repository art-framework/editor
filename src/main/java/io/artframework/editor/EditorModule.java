package io.artframework.editor;

import io.artframework.BootstrapScope;
import io.artframework.Scope;
import io.artframework.annotations.ArtModule;
import io.artframework.annotations.OnBootstrap;
import io.artframework.annotations.OnDisable;
import io.artframework.annotations.OnEnable;
import io.artframework.annotations.OnLoad;
import io.artframework.annotations.OnReload;

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

    @OnBootstrap
    public void onBootstrap(BootstrapScope scope) {

        this.editor = new DummyEditor(scope);

        scope.addSingletonProvider(Editor.class, editor);
    }
    
    @OnLoad
    public void onLoad(Scope scope) {

    }
    
    @OnEnable
    public void onEnable(Scope scope) {

    }

    @OnReload
    public void onReload(Scope scope) {

    }

    @OnDisable
    public void onDisable(Scope scope) {

    }
}
