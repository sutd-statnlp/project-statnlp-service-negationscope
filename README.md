# Negation Scope Service
[![Build Status](https://travis-ci.org/sutd-statnlp/service-negationscope.svg?branch=master)](https://travis-ci.org/sutd-statnlp/service-negationscope)
[![codecov](https://codecov.io/gh/sutd-statnlp/service-negationscope/branch/master/graph/badge.svg)](https://codecov.io/gh/sutd-statnlp/service-negationscope)
[![](https://sonarcloud.io/api/project_badges/measure?project=org.statnlp.services%3Aservice-negationscope&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.statnlp.services%3Aservice-negationscope)
[![](https://sonarcloud.io/api/project_badges/measure?project=org.statnlp.services%3Aservice-negationscope&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=org.statnlp.services%3Aservice-negationscope)
[![](https://images.microbadger.com/badges/image/statnlp/service-negationscope.svg)](https://microbadger.com/images/statnlp/service-negationscope)
[![JavaDoc](https://img.shields.io/badge/javadoc-API-blue.svg)](http://service-negationscope.statnlp.org/apidocs/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/sutd-statnlp/service-negationscope/blob/master/LICENSE)

## Installation
Install dependencies

```
./mvnw clean install

```

## Running the tests

Run all tests

```
./mvnw test
```

## Build

Build package
``` bash
./mvnw package
```

## Docker support 

Build docker image

```
bash script/Dockerbuild.sh
```

Run docker container

```

docker run -d --name service-negationscope -p 8000:8000 statnlp/service-negationscope
```
## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/sutd-statnlp/service-negationscope/tags). 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

