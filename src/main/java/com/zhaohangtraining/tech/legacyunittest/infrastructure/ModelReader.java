package com.zhaohangtraining.tech.legacyunittest.infrastructure;

import com.zhaohangtraining.tech.legacyunittest.configuration.DryConfiguration;

import java.io.IOException;
import java.io.Reader;


public class ModelReader extends Reader {
    public ModelReader(DryConfiguration dryConfiguration) {
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
