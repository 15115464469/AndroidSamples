package com.cnkind.common.mvp;

public interface BaseContract {

    interface Present<IModel> extends IPresent {

    }

    interface View<T extends Present> extends IView<T> {

        /**
         * 设置Present
         *
         * @param presenter
         */
        void setPresenter(T presenter);
    }

}
