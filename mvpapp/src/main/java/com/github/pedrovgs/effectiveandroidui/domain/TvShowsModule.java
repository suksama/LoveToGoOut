/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module created to provide every domain dependencies as interactors or the main class of
 * this application: Catalog.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true, complete = false)
public final class TvShowsModule {

  @Provides @Singleton Catalog provideCatalog() {
    return new Catalog();
  }

  @Provides GetTvShows provideGetTvShowsInteractor(GetTvShowsInteractor interactor) {
    return interactor;
  }

  @Provides GetTvShowById provideGetTvShowbyIdInteractor(GetTvShowByIdInteractor interactor) {
    return interactor;
  }
}
