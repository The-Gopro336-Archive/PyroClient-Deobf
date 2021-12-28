/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.launcher.LoaderGui$ImgBkg;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2={"<anonymous>", "", "invoke", "dev/nuker/pyro/launcher/LoaderGui$1$1"})
final class LoaderGui$$special$$inlined$apply$lambda$11
extends Lambda
implements Function0 {
    final /* synthetic */ LoaderGui$ImgBkg Field2363;
    final /* synthetic */ LoaderGui Field2364;
    final /* synthetic */ LoaderGui Field2365;

    LoaderGui$$special$$inlined$apply$lambda$11(LoaderGui$ImgBkg imgBkg, LoaderGui loaderGui, LoaderGui loaderGui2) {
        this.Field2363 = imgBkg;
        this.Field2364 = loaderGui;
        this.Field2365 = loaderGui2;
        super(0);
    }

    public final void Method3860() {
        while (true) {
            Thread.sleep(1L);
            double d = this.Field2364.Method12439();
            if (d == -1.0) {
                if (LoaderGui.Method12447(this.Field2364) == 1) {
                    LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                    loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() + 5.0E-4f);
                    if (this.Field2363.Method8044() > 1.0f) {
                        LoaderGui.Method12448(this.Field2364, -1);
                    }
                } else {
                    LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                    loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() - 5.0E-4f);
                    if (this.Field2363.Method8044() < 0.6f) {
                        LoaderGui.Method12448(this.Field2364, 1);
                    }
                }
                this.Field2365.repaint();
            } else if (d == -2.0) {
                if ((double)this.Field2363.Method8044() < 1.0) {
                    LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                    loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() + 5.0E-4f);
                    this.Field2365.repaint();
                }
            } else if (d == -5.0) {
                if ((double)this.Field2363.Method8044() < 1.0 || (double)this.Field2363.Method8047() < 1.0) {
                    if (this.Field2363.Method8044() < 0.35f) {
                        LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                        loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() + 5.0E-4f);
                    } else if (this.Field2363.Method8044() > 0.4f) {
                        LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                        loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() - 5.0E-4f);
                    }
                    if ((double)this.Field2363.Method8047() > 1.0) {
                        LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                        loaderGui$ImgBkg.Method8048(loaderGui$ImgBkg.Method8047() - 5.0E-4f);
                    } else if ((double)this.Field2363.Method8047() < 0.9) {
                        if (this.Field2363.Method8047() < this.Field2363.Method8044()) {
                            this.Field2363.Method8048(this.Field2363.Method8044());
                        }
                        LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                        loaderGui$ImgBkg.Method8048(loaderGui$ImgBkg.Method8047() + 0.002f);
                    }
                    this.Field2365.repaint();
                }
            } else if (d == -3.0) {
                if ((double)this.Field2363.Method8044() > 0.5) {
                    LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                    loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() - 0.001f);
                    this.Field2365.repaint();
                }
            } else {
                if ((double)this.Field2363.Method8044() > 0.5) {
                    LoaderGui$ImgBkg loaderGui$ImgBkg = this.Field2363;
                    loaderGui$ImgBkg.Method8045(loaderGui$ImgBkg.Method8044() - 0.001f);
                    this.Field2365.repaint();
                }
                if (this.Field2363.Method8042() != this.Field2364.Method12439()) {
                    this.Field2363.Method8043(this.Field2364.Method12439());
                    this.Field2365.repaint();
                }
            }
            this.Field2363.Method8054();
        }
    }
}

