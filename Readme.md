[![Build Status](../../workflows/Build/badge.svg)](../../actions?query=workflow%3ABuild)
[![GitHub release (latest SemVer including pre-releases)](https://img.shields.io/github/v/release/art-framework/art-module-template?include_prereleases&label=release)](../../releases)
[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg)](http://commitizen.github.io/cz-cli/)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![art-framework-badge](https://raw.githubusercontent.com/gist/Silthus/a88fd35b722da343658d54c474c0e5c1/raw/586ba19363678ffc6880de679490f8abb6db3f19/badge.svg)](https://art-framework.io)

# ART-Editor API

This module extends the [art-framework](https://art-framework.io) with an editor API that can be used to implemented web or ingame editors.

```java
import com.sun.source.tree.Scope;

public class MyEditor implements FlowEditor<Player> {

  private final Scope scope;

  public MyEditor(Scope scope) {
    this.scope = scope;
  }

  @Override
  public EditorSession<List<String>> edit(List<String> input) {

    // gather all required data then create the session
    return new DefaultSession(input);
  }

  @Override
  public void open(@NonNull Player player, @NonNull EditorSession<List<String>> session) {

    // open the editor session for the given player
  }
}

@ArtModule(
        value = "my-editor",
        description = {
                "My cool ART web editor.",
        },
        version = "@VERSION@",
        prefix = "my-editor"
)
public class MyEditorModule {

  private MyEditor editor;

  @OnBootstrap
  public void onBootstrap(BootstrapScope scope) {

    this.editor = new MyEditor(scope);

    scope.addSingletonProvider(MyEditor.class, editor);
  }
}
```