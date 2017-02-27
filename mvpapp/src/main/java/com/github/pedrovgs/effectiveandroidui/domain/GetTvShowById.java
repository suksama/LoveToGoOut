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

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;

/**
 * Get a TvShow given a TvShow identifier. Return the result using a Callback.
 *
 * This interactor can execute onTvShowNotFound Callback method if there is no any tv show that
 * matches with the tvShowId passed as parameter. Other possible result is the execution of
 * OnConnectionError when there is no internet connection and the client code executes this
 * interactor.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface GetTvShowById {

  interface Callback {
    void onTvShowLoaded(final TvShow tvShow);

    void onTvShowNotFound();

    void onConnectionError();
  }

  void execute(final String tvShowId, final Callback callback);
}
