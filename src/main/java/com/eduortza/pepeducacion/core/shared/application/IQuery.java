package com.eduortza.pepeducacion.core.shared.application;

import com.eduortza.pepeducacion.core.shared.domain.Result;

public interface IQuery<G, R> {
    Result<R> query(G params);
}
