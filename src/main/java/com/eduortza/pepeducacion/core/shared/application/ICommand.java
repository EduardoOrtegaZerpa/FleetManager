package com.eduortza.pepeducacion.core.shared.application;

import com.eduortza.pepeducacion.core.shared.domain.Result;

public interface ICommand<G, T> {
    Result<G> run(T request);
}
