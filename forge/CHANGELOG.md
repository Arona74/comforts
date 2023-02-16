# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project does not adhere to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).
This project uses MCVERSION-MAJORMOD.MAJORAPI.MINOR.PATCH.

## [1.18.2-5.0.0.6] - 2023.02.16
### Fixed
- Fixed dedicated server crashes related to Creative tabs [#114](https://github.com/illusivesoulworks/comforts/issues/114)

## [1.18.2-5.0.0.5] - 2022.10.05
### Fixed
- Fixed arm being raised when sleeping in a sleeping bag [#80](https://github.com/illusivesoulworks/comforts/issues/80)
- Fixed hammock "cannot sleep now" message to include nights and thunderstorms when the `nightHammocks` configuration is
  true [#87](https://github.com/illusivesoulworks/comforts/issues/87)
- Fixed sleeping bags not being destroyed properly when using the `sleepingBagBreakage` configuration [#101](https://github.com/illusivesoulworks/comforts/issues/101)

## [1.18.2-5.0.0.4] - 2022.03.08
### Fixed
- Fixed auto-using sleeping bags not working properly

## [1.18.2-5.0.0.3] - 2022.03.07
### Changed
- Updated `fr_fr.json` localization (thanks HollishKid!) [#75](https://github.com/TheIllusiveC4/Comforts/pull/75)
### Fixed
- Fixed players unlocking all Comforts recipes when gaining any item [#61](https://github.com/TheIllusiveC4/Comforts/issues/61)

## [1.18.1-5.0.0.2] - 2022.02.16
### Changed
- Attempting invalid placements for hammocks will now provide general feedback messages to the player about what went
wrong
- Rope and Nail can now be crafted with any item tagged `forge:rope`, with native support for Quark and Supplementaries
rope items

## [1.18-5.0.0.1] - 2021.12.05
### Changed
- Updated to Minecraft 1.18
- Updated to Forge 38+
