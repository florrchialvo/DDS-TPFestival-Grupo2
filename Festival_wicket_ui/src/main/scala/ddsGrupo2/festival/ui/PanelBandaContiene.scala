package ddsGrupo2.festival.ui

import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import ddsGrupo2.festival.model._
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.PropertyModel
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.model.ComponentPropertyModel
import scala.collection.JavaConverters._
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.basic.Label

class PanelBandaContiene extends PanelBuscador {
  val bandasPorFestival = new BandasPorFestival
  val filtroContiene = new FiltroBandaContiene
  setUp

  override def addComponents(form: Form[Buscador[_]]) {
    form.add(new TextField("contiene", new PropertyModel[String](filtroContiene, "bandaContiene")))
    form.add(new DropDownChoice[Festival]("festival",
      new PropertyModel[Festival](bandasPorFestival, "festival"),
      new PropertyModel(bandasPorFestival, "listaFestivales")))
  }

  override def createModel(form: Form[Buscador[_]]) = {
    form.setModel(new CompoundPropertyModel(
      new Buscador(bandasPorFestival, filtroContiene)))
  }
}


