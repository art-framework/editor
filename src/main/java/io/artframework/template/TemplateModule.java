package io.artframework.template;

import io.artframework.Scope;
import io.artframework.annotations.ArtModule;
import io.artframework.annotations.OnDisable;
import io.artframework.annotations.OnEnable;
import io.artframework.annotations.OnLoad;
import io.artframework.annotations.OnReload;

@ArtModule(
    value = "art-module-template",
    description = "Add a short and precise description about your module here.",
    version = "@VERSION@",
    prefix = "art-template",
    depends = {
        // add any plugin or module dependencies of your module here
        // "plugin:Vault"
        // "module:custom-parser"
    }
)
public class TemplateModule {
    
    @OnLoad
    public void onLoad(Scope scope) {

    }
    
    @OnReload
    public void onReload(Scope scope) {

    }

    @OnEnable
    public void onEnable(Scope scope) {

    }

    @OnDisable
    public void onDisable(Scope scope) {

    }
}
