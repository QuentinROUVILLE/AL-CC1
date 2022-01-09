package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.kernel.*;
import fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.RetrieveMembers;
import fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.RetrieveMembersHandler;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberCommandHandler;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberEvent;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberEventListener;
import fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod.ModifyMemberPaymentMethodCommandHandler;
import fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod.ModifyMemberPaymentMethodEvent;
import fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod.ModifyMemberPaymentMethodEventListener;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.infrastructure.DefaultEventDispatcher;
import fr.esgi.quentinrouville.use_case.member.infrastructure.InMemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfiguration {
    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyMemberPaymentMethodEvent.class, List.of(new ModifyMemberPaymentMethodEventListener()));
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateMemberCommandHandler createMemberCommandHandler() {
        return CreateMemberCommandHandler.of(memberRepository(), eventEventDispatcher());
    }

    @Bean
    public ModifyMemberPaymentMethodCommandHandler modifyMemberAddressCommandHandler() {
        return ModifyMemberPaymentMethodCommandHandler.of(memberRepository(), eventEventDispatcher());
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveMembers.class, new RetrieveMembersHandler(memberRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }
}
