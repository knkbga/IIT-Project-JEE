package com.example.nitin.myapp;

import java.io.Serializable;

import questionTypes.*;

/**
 * Created by kanak on 3/9/16.
 */

public class SampleQuestions implements Serializable
{
    public SingleChoice singleChoice[];
    public MultipleChoice multipleChoice[];
    public Numericals numericals[];
    public SampleQuestions()
    {
        this.singleChoice = new SingleChoice[5];

        //Single 1st question

        String preQuestionStatement="<p>In a historical experiment to determine Planck&lsquo;s constant, a metal surface was irradiated with light of different wavelengths. The emitted photoelectron energies were measured by applying a stopping potential. The relevant data for the wavelength (&lambda;) of incident light and the corresponding stopping potential (V<sub>0</sub>) are given below: </p>";
        Option options1_1[] = new Option[4];

        String str = "<span class=\"option_value\">6.0 &times; 10<sup>-34</sup></span>";
        options1_1[0] = new Option(str, false);
        str = "<span class=\"option_value\">6.4 &times; 10<sup>-34</sup></span>";
        options1_1[1] = new Option(str, true);
        str = "<span class=\"option_value\">6.6 &times; 10<sup>-34</sup></span>";
        options1_1[2] = new Option(str, false);
        str = "<span class=\"option_value\">6.8 &times; 10<sup>-34</sup></span>";
        options1_1[3] = new Option(str, false);

        shuffle<Option> obj = new shuffle(options1_1);
        options1_1 = obj.shuffle_elements();

        singleChoice[0] =new SingleChoice(preQuestionStatement,null,null,options1_1);

        //Single 2nd question

        preQuestionStatement = "A parallel beam of light is incident from air at an angle &alpha; on the side PQ of a right angled triangular prism of refractive index n = &radic; <span>2</span>. Light undergoes total internal reflection in the prism at the face PR when &alpha; has a minimum value of 45<sup>0</sup>.The angle &theta; of the prism is ";
        Option options1_2[] = new Option[4];

        str = "<span class=\"option_value\"> 15<sup>0</sup> </span>";
        options1_2[0] = new Option(str,true);
        str = "<span class=\"option_value\"> 22.5<sup>0</sup> </span>";
        options1_2[1] = new Option(str,false);
        str = "<span class=\"option_value\"> 30<sup>0</sup> </span>";
        options1_2[2] = new Option(str,false);
        str = "<span class=\"option_value\"> 45<sup>0</sup> </span>";
        options1_2[3] = new Option(str,false);

        obj = new shuffle(options1_2);
        options1_2 = obj.shuffle_elements();

        singleChoice[1] =new SingleChoice(preQuestionStatement,null,null,options1_2);


        //Single 3nd question

        preQuestionStatement = "The ends Q and R of two thin wires, PQ and RS, are soldered &#40;joined&#41; together. Initially each of the wires has a length of 1 m at 10 <sup>0</sup>C. Now the end P is maintained at 10 <sup>0</sup>C, while the end S is heated and maintained at 400 0<sup>0</sup>C. The system is thermally insulated from its surroundings. If the thermal conductivity of wire PQ is twice that of the wire RS and the coefficient of linear thermal expansion of PQ is 1.2 &#42; 10<sup>-5</sup> K<sup>-1</sup>, the change in length of the wire PQ is";
        Option options1_3[] = new Option[4];

        str = "<span class=\"option_value\">0.78 mm</span>";
        options1_3[0] = new Option(str,true);
        str = "<span class=\"option_value\">0.90 mm</span>";
        options1_3[1] = new Option(str,false);
        str = "<span class=\"option_value\">1.56 mm</span>";
        options1_3[2] = new Option(str,false);
        str = "<span class=\"option_value\">2.34 mm</span>";
        options1_3[3] = new Option(str,false);

        obj = new shuffle(options1_3);
        options1_3 = obj.shuffle_elements();

        singleChoice[2] =new SingleChoice(preQuestionStatement,null,null,options1_3);

        //Single 4th question

        preQuestionStatement = "An accident in a nuclear laboratory resulted in deposition of a certain amount of radioactive material of half-life 18 days inside the laboratory. Tests revealed that the radiation was 64 times more than the permissible level required for safe operation of the laboratory. What is the minimum number of days after which the laboratory can be considered safe for use?";
        Option options1_4[] = new Option[4];

        str = "<span class=\"option_value\">64</span>";
        options1_4[0] = new Option(str,true);
        str = "<span class=\"option_value\">90</span>";
        options1_4[1] = new Option(str,false);
        str = "<span class=\"option_value\">108</span>";
        options1_4[2] = new Option(str,false);
        str = "<span class=\"option_value\">120</span>";
        options1_4[3] = new Option(str,false);

        obj = new shuffle(options1_4);
        options1_4 = obj.shuffle_elements();

        singleChoice[3] =new SingleChoice(preQuestionStatement,null,null,options1_4);


        //Single 5th question

        preQuestionStatement = "A small object is placed 50 cm to the left of a thin convex lens of focal length 30 cm. A convex spherical mirror of radius of curvature 100 cm is placed to the right of the lens at a distance of 50 cm. The mirror is tilted such that the axis of the mirror is at an angle &theta; = 30<sup>0</sup> to the axis of the lens, as shown in the figure.";
        Option options1_5[] = new Option[4];

        str = "<span class=\"option_value\">&#40;25, 25&radic;<span>3</span> &#41; </span>";
        options1_5[0] = new Option(str,true);
        str = "<span class=\"option_value\">&#40;125/3 , 25/&radic;<span>3</span> &#41; </span>";
        options1_5[1] = new Option(str,false);
        str = "<span class=\"option_value\">&#40; 50-25&radic;<span>3</span> , 25&#41; </span>";
        options1_5[2] = new Option(str,false);
        str = "<span class=\"option_value\">&#40; 0,0 &#41;</span>";
        options1_5[3] = new Option(str,false);

        obj = new shuffle(options1_5);
        options1_5 = obj.shuffle_elements();

        singleChoice[4] =new SingleChoice(preQuestionStatement,null,null,options1_5);

















        this.multipleChoice = new MultipleChoice[5];

        //Multiple 1st question

        preQuestionStatement="An infinite line charge of uniform electric charge density &lambda; lies along the axis of an electrically conducting infinite cylindrical shell of radius R. At time t = 0, the space inside the cylinder is filled with a material of permittivity &epsilon; and electrical conductivity &sigma;. The electrical conduction in the material follows Ohm’s law. Which one of the following graphs best describes the subsequent variation of the magnitude of current density j(t) at any point in the material?";

        Option options2_1[] = new Option[4];

        str = "<img src='q5a.png'>";
        options2_1[0] = new Option(str, false);
        str = "<img src='q5b.png'>";
        options2_1[1] = new Option(str, false);
        str = "<img src='q5c.png'>";
        options2_1[2] = new Option(str, true);
        str = "<img src='q5d.png'>";
        options2_1[3] = new Option(str, false);

        obj = new shuffle(options2_1);
        options2_1 = obj.shuffle_elements();

        this.multipleChoice[0] = new MultipleChoice(preQuestionStatement,null,null,options2_1);

        //Multiple 2nd question

        preQuestionStatement = "A uniform wooden stick of mass 1.6 kg and length l rests in an inclined manner on a smooth, vertical wall of height &lt; l such that a small portion of the stick extends beyond the wall. The reaction force of the wall on the stick is perpendicular to the stick. The stick makes an angle of 30<sup>0</sup> with the wall and the bottom of the stick is on a rough floor. The reaction of the wall on the stick is equal in magnitude to the reaction of the floor on the stick. The ratio h/l and the frictional force f at the bottom of the stick are";
        Option options2_2[] = new Option[4];

        str = "<span class=\"option_value\"> h/l = &radic;<span>3</span>/16 , f = N*16&radic;<span>3</span>/3 </span>";
        options2_2[0] = new Option(str,true);
        str = "<span class=\"option_value\"> h/l = 3/16 , f = N*16&radic;<span>3</span>/3 </span>";
        options2_2[1] = new Option(str,false);
        str = "<span class=\"option_value\"> h/l = 3&radic;<span>3</span>/16 , f = N*8&radic;<span>3</span>/3 </span>";
        options2_2[2] = new Option(str,false);
        str = "<span class=\"option_value\"> h/l = 3&radic;<span>3</span>/16 , f = N*16&radic;<span>3</span>/3 </span>";
        options2_2[3] = new Option(str,false);

        obj = new shuffle(options2_2);
        options2_2 = obj.shuffle_elements();

        multipleChoice[1] = new MultipleChoice(preQuestionStatement,null,null,options2_2);

        //Multiple 3rd question

        preQuestionStatement = "Highly excited states for hydrogen-like atoms&#40; also called Rydberg states&#41;with nuclear charge Ze are defined by their principal quantum number n,, where n&gt;&gt; 1. Which of the following statement&#40;s&#41; is &#40;are&#41; true?";
        Option options2_3[] = new Option[4];

        str = "<span class=\"option_value\">Relative change in the radii of two consecutive orbitals does not depend on Z<br><br></span>";
        options2_3[0] = new Option(str,false);
        str = "<span class=\"option_value\">Relative change in the radii of two consecutive orbitals varies as 1/n<br><br></span>";
        options2_3[1] = new Option(str,false);
        str = "<span class=\"option_value\">Relative change in the energy of two consecutive orbitals varies as 1/n<sup>3</sup><br><br></span>";
        options2_3[2] = new Option(str,false);
        str = "<span class=\"option_value\">Relative change in the angular momenta of two consecutive orbitals varies as 1/n<sup>3</sup><br><br></span>";
        options2_3[3] = new Option(str,true);

        obj = new shuffle<>(options2_3);
        options2_3 = obj.shuffle_elements();

        multipleChoice[2] = new MultipleChoice(preQuestionStatement,null,null,options2_3);

        //Multiple 4th question

        preQuestionStatement = "An incandescent bulb has a thin filament of tungsten that is heated to high temperature by passing an electric current. The hot filament emits black-body radiation. The filament is observed to break up at random locations after a sufficiently long time of operation due to non-uniform evaporation of tungsten from the filament. If the bulb is powered at constant voltage, which of the following statement&#40;s&#41; is&#40;are&#41; true";
        Option options2_4[] = new Option[4];

        str = "<span class=\"option_value\">The temperature distribution over the filament is uniform<br><br></span>";
        options2_4[0] =new Option(str,false);
        str = "<span class=\"option_value\">The resistance over small sections of the filament decreases with time<br><br></span>";
        options2_4[1] = new Option(str,false);
        str = "<span class=\"option_value\">The filament emits more light at higher band of frequencies before it breaks up<br><br></span>";
        options2_4[2] =new Option(str,false);
        str = "<span class=\"option_value\">The filament consumes less electrical power towards the end of the life of the bulb<br><br></span>";
        options2_4[3] = new Option(str,true);

        obj = new shuffle<>(options2_4);
        options2_4 = obj.shuffle_elements();

        multipleChoice[3] = new MultipleChoice(preQuestionStatement,null,null,options2_4);

        // Multiple 5th question

        preQuestionStatement = "A plano-convex lens is made of a material of refractive index n. When a small object is placed 30 cm away in front of the curved surface of the lens, an image of double the size of the object is produced. Due to reflection from the convex surface of the lens, another faint image is observed at a distance of 10 cm away from the lens. Which of the following statement&#40;s&#41; is &#40;are&#41; true";
        Option options2_5[] =new Option[4];

        str = "<span class=\"option_value\">The refractive index of the lens is 2.5</span>";
        options2_5[0] = new Option(str,true);
        str = "<span class=\"option_value\">The radius of curvature of the convex surface is 45 cm</span>";
        options2_5[1] = new Option(str,false);
        str = "<span class=\"option_value\">The faint image is erect and real</span>";
        options2_5[2] = new Option(str,false);
        str = "<span class=\"option_value\">The focal length of the lens is 20 cm</span>";
        options2_5[3] = new Option(str,true);

        obj = new shuffle<>(options2_5);
        options2_5 = obj.shuffle_elements();

        multipleChoice[4] =new MultipleChoice(preQuestionStatement,null,null,options2_5);












        //Numerical Questions

        this.numericals = new Numericals[5];


        preQuestionStatement = "An electron in an excited state of Li<sup>2+</sup> ion has angular momentum 3h/2&pi;. The de Broglie wavelength of the electron in this state is p&pi;a<sub>o</sub> where &#40;a<sub>o</sub> is the Bohr radius&#41;. The value of p is";
        numericals[0] = new Numericals(preQuestionStatement,null,null,new Option("1",true));

        preQuestionStatement = "A uniform string of length 20m is suspended from arigid support. A short wave pulse is introduced at its lower end.It starts wave pulse is introduced at its lower end. It starts moving up the string. The time taken to reach the support is:&#40;take g = 10ms<sup>-2</sup>&#41;";
        numericals[1] = new Numericals(preQuestionStatement,null,null,new Option("1",true));

        preQuestionStatement = "A hydrogen atom in its ground state is irradiated by light of wavelength 970&#8491;Taking hc / e = 1.237&#42;10<sup>-6</sup> eV m and the ground state energy of hydrogen atom as –13.6 eV, the number of lines present in the emission spectrum is";
        numericals[2] = new Numericals(preQuestionStatement,null,null,new Option("1",true));

        preQuestionStatement = "Consider two solid spheres P and Q each of density 8 gm cm<sup>-3</sup>and diameters 1cm and 0.5cm, respectively. Sphere P is dropped into a liquid of density 0.8 gm cm<sup>-3</sup> and viscosity&eta; = 3 poiseulles. Sphere Q is dropped into a liquid of density 1.6 gm cm<sup>-3</sup> and viscosity&eta; = 2 poiseulles. The ratio of the terminal velocities of P and Q is";
        numericals[3] = new Numericals(preQuestionStatement,null,null,new Option("1",true));

        preQuestionStatement = "Two inductors L<sub>2</sub> &#40;inductance 1 mH,internal resistance 3&#8486;&#41;and L 2&$40;inductance 2 mH, internal resistance 4&#8486;, and a resistor R&#40;resistance 12 &#8486;&#41;are all connected in parallel across a 5V battery.The circuit is switched on at time t = 0. The ratio of the maximum to the minimum current&#40;T<sub>max</sub>/I<sub>min</sub>&#41;drawn from the battery is";
        numericals[4] = new Numericals(preQuestionStatement,null,null,new Option("1",true));
    }
}