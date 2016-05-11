# EducationalAppDemo

Demo app that shows the qualifications from Gojimo api

## Table of Contents
* [Libraries Used](#libraries-used)
* [Known Issues](#known-issues)
* [Future Improvements](#future-improvements)

## Libraries Used
- Retrofit 2.0 (Annotated REST Client)
- JUnit (Unit Testing)
- Gradle (Task & dependency management)

## Known Issues


## Future Improvements
- Reduce amount of calls.
  - Storing the data locally and refresh from the server as requested, taking advantage of the HTTP headers to avoid downloads of non-stale data. *(Currently caching for 640000ms=~10min)*
- Tablet / Grid Layout compatibility.
