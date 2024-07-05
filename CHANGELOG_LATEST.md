The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

This is a copy of the changelog for the most recent version. For the full version history, go [here](https://github.com/illusivesoulworks/comforts/blob/1.20.x/CHANGELOG.md).

## [6.4.0+1.20.1] - 2024.07.04
### Added
- Added `daySleepingPercentage` configuration for setting the number of players needed to sleep through the day [#142](https://github.com/illusivesoulworks/comforts/issues/142)
- Added `dayWakeTimeOffset` and `nightWakeTimeOffset` configurations to edit the wake time after sleeping through the
  night or day respectively [#128](https://github.com/illusivesoulworks/comforts/issues/128)
- Added `hammocksStopPhantoms` and `sleepingBagsStopPhantoms` configuration values for determining whether sleeping on
  the respective blocks count towards rest against phantom spawns [#151](https://github.com/illusivesoulworks/comforts/issues/151)
### Fixed
- Fixed sleep messages in multiplayer referring to night when sleeping during the day
