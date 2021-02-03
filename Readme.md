[![Build Status](../../workflows/Build/badge.svg)](../../actions?query=workflow%3ABuild)
[![GitHub release (latest SemVer including pre-releases)](https://img.shields.io/github/v/release/art-framework/art-module-template?include_prereleases&label=release)](../../releases)
[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg)](http://commitizen.github.io/cz-cli/)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![art-framework-badge](https://raw.githubusercontent.com/gist/Silthus/a88fd35b722da343658d54c474c0e5c1/raw/586ba19363678ffc6880de679490f8abb6db3f19/badge.svg)](https://art-framework.io)

# art-module template

Use this template to quickstart your art-module development.

Take a look at the [art-framework documentation](https://art-framework.io/#/developer/modules) for more details.

## Template Setup

* Create a new Github project using this template.
* Clone the new repository and open it in IntelliJ.
* Update the `gradle.properties` file and change the following variables:
    * `group`: your-maven-group-id (e.g.: io.github.silthus)
* Update the `root.projectName` inside `settings.gradle`. This will be your artifactId.
* Delete the `CHANGELOG.md` file. It will be created on your first release. 
* Rename the java package and module to match your project.
* Code away :) - and once you are ready, push your commit (in [conventional commit style](https://www.conventionalcommits.org/)) to master.
