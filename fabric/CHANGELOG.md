# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [1.1.3-1.18.2] - 2022.10.05
### Fixed
- Fixed arm being raised when sleeping in a sleeping bag [#80](https://github.com/illusivesoulworks/comforts/issues/80)
- Fixed hammock "cannot sleep now" message to include nights and thunderstorms when the `nightHammocks` configuration is
true [#87](https://github.com/illusivesoulworks/comforts/issues/87)
- Fixed sleeping bags not being destroyed properly when using the `sleepingBagBreakage` configuration [#101](https://github.com/illusivesoulworks/comforts/issues/101)

## [1.1.2-1.18.2] - 2022.03.08
### Fixed
- Fixed auto-using sleeping bags not working properly

## [1.1.1-1.18.2] - 2022.03.08
### Added
- Added `comforts:sleeping_bags` and `comforts:hammocks` item and block tags for Comforts sleeping bags and hammocks

## [1.1.0-1.18.2] - 2022.03.07
### Changed
- Updated to Minecraft 1.18.2

## [1.0.3-1.18.1] - 2022.03.07
### Changed
- Updated `fr_fr.json` localization (thanks HollishKid!) [#75](https://github.com/TheIllusiveC4/Comforts/pull/75)
- Added a new tag `c:rope` and a new shapeless recipe that uses it for Rope and Nail
### Fixed
- Fixed players unlocking all Comforts recipes when gaining any item [#61](https://github.com/TheIllusiveC4/Comforts/issues/61)
- Fixed compatibility issues with Haema

## [1.0.2-1.18.1] - 2022.02.16
### Changed
- Attempting invalid placements for hammocks will now provide general feedback messages to the player about what went
  wrong

## [1.0.1-1.18.1] - 2022.01.27
### Changed
- Updated to Minecraft 1.18.1
- Updated to Fabric API 0.46.1+
- Updated to Cloth Config 6.1.48+
- Updated to Cardinal Components API 4.1.0+

## [1.0.0-1.18] - 2021.12.06
### Changed
- Updated to Minecraft 1.18
- Updated to Fabric API 0.44.0+
