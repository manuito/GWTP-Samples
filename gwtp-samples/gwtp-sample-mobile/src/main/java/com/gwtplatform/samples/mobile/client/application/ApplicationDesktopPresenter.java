/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.mobile.client.application;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.samples.mobile.client.application.breadcrumbs.BreadcrumbsPresenter;
import com.gwtplatform.samples.mobile.client.application.products.ProductsPresenter;
import com.gwtplatform.samples.mobile.client.place.NameTokens;

public class ApplicationDesktopPresenter extends AbstractApplicationPresenter implements ApplicationUiHandlers {
    private PlaceManager placeManager;

    @Inject
    public ApplicationDesktopPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, BreadcrumbsPresenter.TYPE_SetMainContent);

        this.placeManager = placeManager;

        view.setUiHandlers(this);
    }

    @Override
    public void revealAllProductsList() {
        placeManager.revealRelativePlace(new PlaceRequest(NameTokens.productList).with(ProductsPresenter.TOKEN_TYPE,
                ProductsPresenter.TYPE_ALL_PRODUCTS));
    }

    @Override
    public void revealFavoriteProductsList() {
        placeManager.revealRelativePlace(new PlaceRequest(NameTokens.productList).with(ProductsPresenter.TOKEN_TYPE,
                ProductsPresenter.TYPE_FAVORITE_PRODUCTS));
    }

    @Override
    public void revealSpecialsList() {
        placeManager.revealRelativePlace(new PlaceRequest(NameTokens.productList).with(ProductsPresenter.TOKEN_TYPE,
                ProductsPresenter.TYPE_SPECIALS));
    }
}
