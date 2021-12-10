package com.chenzy.route_processor

import com.chenzy.route.Route
import java.util.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements
import javax.naming.Binding
import javax.tools.Diagnostic
import kotlin.math.E

/**
 * Created by zhangyu on 2021/11/18.
 */
//@AutoService(Processor::class)
class RouteProcessor : AbstractProcessor() {
    private var elementUtils: Elements? = null
    private var mMessager: Messager? = null
    private lateinit var filer: Filer

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        println("RouteProcessor, init()")
        elementUtils = processingEnv.elementUtils
        mMessager = processingEnv.messager
        filer = processingEnv.filer
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        val supportTypes: HashSet<String> = LinkedHashSet()
        supportTypes.add(Route::class.java.canonicalName)
        return supportTypes
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        println("RouteProcessor, getSupportedSourceVersion()")
        return SourceVersion.latestSupported()
    }

    override fun process(set: Set<TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        mMessager!!.printMessage(Diagnostic.Kind.NOTE, "processing...")
        println("RouteProcessor, process()")

        //得到所有的注解
        val elements: Set<Element> = roundEnvironment.getElementsAnnotatedWith(Route::class.java)
//        RouteManager.routes.clear()
        for (element in elements) {
            val classElement = element as TypeElement
            val fullClassName = classElement.qualifiedName.toString()
            val bindAnnotation: Route = classElement.getAnnotation<Route>(Route::class.java)
            println("fullClassName: " + fullClassName + ", annotation.path: " + bindAnnotation.path)
//            RouteManager.routes.put(bindAnnotation.path,fullClassName)

            println("position: 1")
            val packageOf = elementUtils!!.getPackageOf(element)
            val annotation = element.getAnnotation(Route::class.java)
            while (element.kind != ElementKind.CLASS) {
                element.enclosingElement
            }
            kotlin.runCatching {
                println("CodeProcess: createCode()")
                CodeProcess(
                    element,
                    packageOf,
                    element as TypeElement,
                    annotation.path
                ).createCode(filer)
            }.onFailure { e ->
                println("createCode fail, "+e.localizedMessage)
            }
        }
        println("position: 2")

        return true
    }
}